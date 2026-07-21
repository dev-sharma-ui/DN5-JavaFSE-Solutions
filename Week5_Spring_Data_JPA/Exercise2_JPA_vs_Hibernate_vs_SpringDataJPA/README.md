# Difference between JPA, Hibernate and Spring Data JPA

## JPA (Java Persistence API)

- JPA is a Java specification for Object Relational Mapping (ORM).
- It defines a standard API for persisting Java objects into relational databases.
- JPA itself does not provide an implementation.

Examples:
- @Entity
- @Id
- @Table

---

## Hibernate

- Hibernate is an implementation of the JPA specification.
- It provides the actual ORM framework.
- It handles database operations, caching, lazy loading, and query execution.

Features:
- ORM Mapping
- HQL
- Caching
- Transaction Management

---

## Spring Data JPA

- Spring Data JPA is built on top of JPA.
- It simplifies database access by reducing boilerplate code.
- It automatically generates CRUD methods through repositories.

Example:

```java
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
}
```

---

## Comparison

| JPA | Hibernate | Spring Data JPA |
|-----|-----------|-----------------|
| Specification | Framework | Spring Module |
| Defines standards | Implements JPA | Simplifies JPA |
| No implementation | Complete ORM | Repository abstraction |
| Vendor Independent | Hibernate specific | Uses JPA implementation |

---

## Relationship

Spring Data JPA
        ↓
       JPA
        ↓
   Hibernate
        ↓
    Database