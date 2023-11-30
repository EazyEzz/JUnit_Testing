# Extra Requirements

## 1. Performance Requirements

- **Response Time:** The system should respond within 2 seconds for 95% of user 
requests during peak load times.
- **Load Time:** Web pages should load within 3 seconds under normal network 
conditions.
- **Concurrent Users:** The system should handle up to 10,000 concurrent users 
during peak times without performance degradation.

## 2. Safety Requirements

- **Data Backup:** All critical data should be backed up daily to an off-site 
location.
- **Disaster Recovery:** In the event of a system failure, full recovery should be 
achievable within 4 hours.
  
## 3. Security Requirements

- **Authentication:** Users must authenticate using a secure username and password 
mechanism.
- **Authorization:** Different user roles should have distinct access levels to 
system features.
- **Data Encryption:** All sensitive data, including user passwords, should be 
encrypted using industry-standard algorithms.
  
## 4. Software Quality Attributes

- **Reliability:** The system should have an uptime of 99.9%.
- **Usability:** New users should be able to navigate the main features of the 
system within 10 minutes.
- **Maintainability:** Any bugs reported should be fixed and deployed within a 
week of being verified.

## 5. Business Rules

- **Order Management:** No order should be processed without available inventory.
- **User Registration:** Email addresses used for registration should be unique. 
No user should be able to register with an already registered email address.
