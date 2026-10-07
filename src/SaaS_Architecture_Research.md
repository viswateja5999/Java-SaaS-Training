Task 4 — Research SaaS Application Architecture

1. What is SaaS?

SaaS stands for Software as a Service.

SaaS is a software delivery model where the application is hosted on the internet and users access it through a web browser or application instead of installing and maintaining the software on their own computers or servers.

Example

Examples of SaaS applications include:

Gmail
Microsoft 365
Salesforce
Slack
Zoom
Simple SaaS Flow
User -->
Web Browser --> SaaS Application --> Backend Server  --> Database

The SaaS provider manages the application, servers, updates, security, and infrastructure.

3. Tenant

A tenant is an individual customer or organization that uses a SaaS application.

In a SaaS system, each customer is commonly represented as a tenant.

Example

Suppose a SaaS application provides employee management.

SaaS Application

|
+---- Company A

|
+---- Company B

|
+---- Company C

Here:

* Company A = Tenant A
* Company B = Tenant B
* Company C = Tenant C

Each tenant can have its own users, data, settings, and subscription.

4. Multi-Tenancy

Multi-tenancy means that a single SaaS application serves multiple tenants or customers.

The application infrastructure and application code can be shared while each tenant's data remains logically separated.

Benefits of Multi-Tenancy
* Reduces infrastructure costs
* Easier application maintenance
* Centralized updates
* Easier scalability
* Efficient resource utilization

5. Tenant Isolation

Tenant isolation means keeping one tenant's data and operations separate from another tenant's data and operations.

For example:

Tenant A

    |
+---- Users

+---- Orders

+---- Subscription

+---- Settings

Tenant B

    |

+---- Users

+---- Orders

+---- Subscription

+---- Settings


Tenant A should not be able to access Tenant B's data.

Example

If Company A requests:

GET /api/orders

the application should return only Company A's orders.

It should not return:

Company B orders
Company C orders
Importance

Tenant isolation is important for:

* Data privacy
* Security
* Access control
* Preventing unauthorized access
* Protecting customer information

6. Subscription Plans

SaaS applications commonly provide different subscription plans.

Example

Free

|

+-- Basic

|

+-- Professional

|

+-- Enterprise

Each plan can provide different features and limits.

7. User Management

User management is the process of creating, updating, managing, and removing users from a SaaS application.

Typical user management operations include:

* User registration
* Login
* Logout
* Password management
* User profile management
* Adding users
* Removing users
* Activating/deactivating users
* Assigning roles
* 
Example
Tenant

|
+---- Admin

|
+---- Manager

|
+---- Employee

Each user belongs to a tenant and can have a specific role.

8. Role-Based Access Control

Role-Based Access Control (RBAC) means controlling access to application features based on a user's role.

Example Roles

* Admin
* Manager
* Employee

Example

Role            -->	Permissions

Admin	    -->    Manage users, settings, billing

Manager	       -->     Manage team and view reports

Employee  --> View and update own information

9. SaaS Billing

SaaS billing is the process of charging customers for using the SaaS application.

Billing can be based on:

* Subscription plan
* Number of users
* Usage
* Storage
* Features
* Billing period

Common Billing Periods
* Monthly
* Yearly

10. SaaS Administration

SaaS administration involves managing the SaaS application and its tenants from an administrative level.

A SaaS administrator may manage:

* Tenants
* Users
* Roles
* Subscription plans
* Billing
* Application settings
* Security settings
* Reports
* System configuration

11. SaaS Security

SaaS security means protecting the application, users, tenant data, and infrastructure from unauthorized access and attacks.

Important security areas include:

* Authentication
* Authorization
* Password security
* Data encryption
* HTTPS
* Access control
* Tenant isolation
* Secure APIs
* Input validation
* Audit logging
* Session/token security

12. Tenant-Level Configuration

Tenant-level configuration means allowing each tenant to customize certain application settings independently.

Example :

Company A may configure:

Company Name: ABC Technologies

Time Zone: IST

Currency: INR

Logo: ABC Logo

Company B may configure:

Company Name: XYZ Solutions

Time Zone: EST

Currency: USD

Logo: XYZ Logo

The application stores these configurations separately for each tenant.

