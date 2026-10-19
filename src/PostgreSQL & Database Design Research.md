Research PostgreSQL & Database Design


1. Core PostgreSQL & Database Design Concepts

    * Schema: A logical namespace that organizes database objects (tables, views, functions). In a multi-tenant SaaS application, schemas are often used for tenant isolation (schema-per-tenant) or simply organizing domain modules (e.g., auth, hr, billing).

    * Table: A structured collection of data rows and columns representing an entity.

    * Primary Key (PK): A column or set of columns that uniquely identifies every row in a table. In modern PostgreSQL, UUID or BIGSERIAL (IDENTITY) are standard choices.

    * Foreign Key (FK): A constraint that ensures referential integrity by pointing to a primary key in another table.

    * Indexes: Data structures (such as B-tree, Hash, or GIN) that improve the speed of data retrieval operations at the cost of write performance and storage space. Crucial on foreign keys, search fields, and frequent WHERE clause columns.

    * Constraints: Rules enforced on data columns (NOT NULL, UNIQUE, CHECK, DEFAULT) to maintain data integrity.

    * Transactions: Sequences of operations executed as a single atomic unit (ACID properties: Atomicity, Consistency, Isolation, Durability) using BEGIN, COMMIT, and ROLLBACK.

    * Normalization: The process of structuring a database to reduce data redundancy and improve data integrity (typically up to 3rd Normal Form - 3NF).

    2. Database Relationships

       Understanding how entities relate to one another is vital for a robust SaaS architecture:

    * One-to-One (1:1): One record in Table A relates to exactly one record in Table B.

      Implementation: Place a Foreign Key with a UNIQUE constraint on one of the tables.

    * One-to-Many (1:N): One record in Table A relates to multiple records in Table B.

      Implementation: Place the Foreign Key pointing to Table A inside Table B (e.g., organizations to users).

    * Many-to-Many (N:M): Multiple records in Table A relate to multiple records in Table B.

      Implementation: Create an intermediate junction/join table containing foreign keys referencing both tables (e.g., users and roles linked via user_roles).

3. SaaS Table Schema Definitions
   Below are the preliminary schema specifications for the requested tables.

A. Core & Multi-Tenancy

    * organizations (Tenants)

        id (PK, UUID)

        name (VARCHAR, NOT NULL)

        slug (VARCHAR, UNIQUE, NOT NULL)

        created_at (TIMESTAMP)

    * subscriptions (SaaS Billing & Plan management)

        id (PK, UUID)

        organization_id (FK to organizations, UNIQUE/Index)

        stripe_customer_id (VARCHAR)

        plan_name (VARCHAR, NOT NULL) -- e.g., Free, Pro, Enterprise

        status (VARCHAR, NOT NULL) -- active, past_due, canceled

        current_period_end (TIMESTAMP)

B. Identity, Access Management (IAM) & Security

    * users

        id (PK, UUID)

        organization_id (FK to organizations)

        email (VARCHAR, UNIQUE, NOT NULL)

        password_hash (VARCHAR, NOT NULL)

        is_active (BOOLEAN)

    * roles

        id (PK, UUID)

        organization_id (FK to organizations, nullable for global roles)

        name (VARCHAR, NOT NULL) -- e.g., Admin, Manager, Employee

    * permissions

        id (PK, UUID)

        code (VARCHAR, UNIQUE, NOT NULL) -- e.g., users:read, payroll:write

    * role_permissions (Junction Table for Roles <-> Permissions)

        role_id (FK to roles)

        permission_id (FK to permissions)

    * user_roles (Junction Table for Users <-> Roles)

        user_id (FK to users)

        role_id (FK to roles)

    * audit_logs

        id (PK, BIGSERIAL)

        organization_id (FK to organizations)

        user_id (FK to users, nullable)

        action (VARCHAR, NOT NULL)

        ip_address (VARCHAR)

        created_at (TIMESTAMP DEFAULT NOW())

C. Human Resources & Operations

    * departments

        id (PK, UUID)

        organization_id (FK to organizations)

        name (VARCHAR, NOT NULL)

    * employees (1:1 with users or separate entity linked to user)

        id (PK, UUID)

        user_id (FK to users, UNIQUE)

        department_id (FK to departments)

        first_name (VARCHAR, NOT NULL)

        last_name (VARCHAR, NOT NULL)

        hire_date (DATE)

    * attendance

        id (PK, BIGSERIAL)

        employee_id (FK to employees)

        clock_in (TIMESTAMP)

        clock_out (TIMESTAMP)

        status (VARCHAR) -- present, absent, remote

    * leave_requests

        id (PK, UUID)

        employee_id (FK to employees)

        leave_type (VARCHAR) -- vacation, sick, personal

        start_date (DATE)

        end_date (DATE)

        status (VARCHAR) -- pending, approved, rejected

    * payroll

        id (PK, UUID)

        employee_id (FK to employees)

        pay_period_start (DATE)

        pay_period_end (DATE)

        gross_pay (NUMERIC)

        net_pay (NUMERIC)

        status (VARCHAR) -- processed, paid


4. Entity-Relationship (ER) Diagram

erDiagram

organizations ||--o{ users : "has"

organizations ||--o{ subscriptions : "manages"

organizations ||--o{ roles : "defines"

organizations ||--o{ departments : "contains"

organizations ||--o{ audit_logs : "generates"

    users ||--o| employees : "profile"
    users ||--o{ user_roles : "assigned"
    users ||--o{ audit_logs : "performs"

    roles ||--o{ user_roles : "grants"
    roles ||--o{ role_permissions : "contains"
    permissions ||--o{ role_permissions : "assigned_to"

    departments ||--o{ employees : "employs"

    employees ||--o{ attendance : "logs"
    employees ||--o{ leave_requests : "submits"
    employees ||--o{ payroll : "receives"