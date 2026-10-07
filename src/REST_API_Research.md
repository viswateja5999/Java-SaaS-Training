# Research: REST API Architecture

---

## 1. HTTP

**HTTP** stands for **HyperText Transfer Protocol**.

It is a communication protocol used to transfer data between a client (frontend) and a server (backend).

In a SaaS application:

```text
Frontend
   |
   | HTTP Request
   ↓
Backend / REST API
   |
   | HTTP Response
   ↓
Frontend
```

### Example

The frontend sends a request:

```http
GET /api/users
```

The backend processes the request and sends a response.

---

## 2. REST

**REST** stands for **Representational State Transfer**.

REST is an architectural style used to design APIs that allow frontend applications to communicate with backend services.

REST APIs commonly use HTTP methods such as:

* GET
* POST
* PUT
* PATCH
* DELETE

### Example

For a SaaS application, users can be treated as a resource:

```text
/api/users
```

Different HTTP methods can perform different operations on the user resource.

| HTTP Method | Operation               |
| ----------- | ----------------------- |
| GET         | Retrieve users          |
| POST        | Create a user           |
| PUT         | Replace a user          |
| PATCH       | Partially update a user |
| DELETE      | Delete a user           |

---

# 3. GET

**GET** is used to retrieve data from the backend.

### Example

```http
GET /api/users
```

This request asks the backend to return the list of users.

### Example Response

```json
[
  {
    "id": 1,
    "name": "John"
  },
  {
    "id": 2,
    "name": "David"
  }
]
```

GET normally does not send data in the request body.

---

# 4. POST

**POST** is used to create a new resource.

### Example

```http
POST /api/users
```

### Request Body

```json
{
  "name": "John",
  "email": "john@example.com"
}
```

The backend creates a new user using the information provided.

### Example Response

```json
{
  "id": 101,
  "name": "John",
  "email": "john@example.com"
}
```

---

# 5. PUT

**PUT** is generally used to completely replace or update an existing resource.

### Example

```http
PUT /api/users/101
```

### Request Body

```json
{
  "name": "John Smith",
  "email": "johnsmith@example.com"
}
```

The backend updates the user identified by ID `101`.

---

# 6. PATCH

**PATCH** is used to partially update an existing resource.

For example, if we only want to change the user's email:

```http
PATCH /api/users/101
```

### Request Body

```json
{
  "email": "newemail@example.com"
}
```

Only the specified field is updated.

### PUT vs PATCH

| PUT                                      | PATCH                              |
| ---------------------------------------- | ---------------------------------- |
| Usually replaces the complete resource   | Updates only selected fields       |
| Complete representation is commonly sent | Partial representation can be sent |
| Used for full updates                    | Used for partial updates           |

---

# 7. DELETE

**DELETE** is used to delete a resource.

### Example

```http
DELETE /api/users/101
```

The backend deletes the user with ID `101`.

A successful DELETE request may return:

```http
204 No Content
```

---

# 8. HTTP Status Codes

HTTP status codes tell the frontend whether the backend request was successful or failed.

### Common Status
Status Code	Meaning
200	OK – Request successful
201	Created – Resource successfully created
204	No Content – Request successful with no response body
400	Bad Request – Invalid request
401	Unauthorized – Authentication is required or failed
403	Forbidden – Access is not allowed
404	Not Found – Resource does not exist
409	Conflict – Request conflicts with existing data
500	Internal Server Error – Server-side error
Example

If a user is successfully created:

HTTP/1.1 201 Created

If the requested user does not exist:

HTTP/1.1 404 Not Found
9. JSON

JSON stands for JavaScript Object Notation.

JSON is a lightweight data format commonly used to exchange data between frontend and backend.

Example
{
"id": 101,
"name": "John",
"email": "john@example.com"
}

JSON uses:

Key-value pairs
Objects
Arrays
JSON Object
{
"name": "John",
"age": 25
}
JSON Array
[
{
"id": 1,
"name": "John"
},
{
"id": 2,
"name": "David"
}
]
10. Request

An HTTP request is sent by the frontend/client to the backend/server.

A request can contain:

* HTTP method
* URL
* Headers
* Path parameters
* Query parameters
* Request body
Example

POST /api/users

Content-Type: application/json

Authorization: Bearer token
{
"name": "John",
"email": "john@example.com"
}
11. Response

An HTTP response is sent by the backend to the frontend after processing a request.

A response can contain:

* Status code
* Headers
* Response body

Example
HTTP/1.1 201 Created
Content-Type: application/json
{
"id": 101,
"name": "John",
"email": "john@example.com"
}
12. Headers

HTTP headers contain additional information about the request or response.

Common Request Headers
Content-Type

Specifies the format of the request body.

Content-Type: application/json
Authorization

Used to send authentication information.

Authorization: Bearer <token>
Common Response Header
Content-Type: application/json

This indicates that the response body contains JSON data.

13. Path Parameters

A path parameter is a value included directly in the URL path.

It is commonly used to identify a specific resource.

Example
GET /api/users/101

Here:

101

is the path parameter representing the user ID.

Another Example
GET /api/organizations/10/users/101

Here:

* 10 = Organization ID
* 101 = User ID

Path parameters are commonly used when the client needs a specific resource.

14. Query Parameters

Query parameters are additional parameters provided after ? in a URL.

They are commonly used for:

* Filtering
* Searching
* Sorting
* Pagination
Example
GET /api/users?department=IT

Here:

department=IT

is a query parameter.

Multiple Query Parameters
GET /api/users?department=IT&page=1&size=10

Here:

department=IT
page=1
size=10

are query parameters.

15. Request Body

The request body contains data sent from the frontend to the backend.

It is commonly used with:

* POST
* PUT
* PATCH
Example
POST /api/users
Content-Type: application/json

Request body:

{
"name": "John",
"email": "john@example.com",
"department": "IT"
}

The backend receives this data and processes it.
