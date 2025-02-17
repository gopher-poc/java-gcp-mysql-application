**Java GCP MySQL Application**
**Prerequisites:** Connect a Spring Boot (3.x.x) application to Cloud SQL MySQL (version 8.x.x)

1. Create a new service account or utilize an existing one.
2. Enable the Cloud SQL Admin API.
3. Assign the Cloud SQL Admin API role to either the new or existing service account.
4. Generate a new key for the service account, download it, and set it as an environment variable on your local machine.
5. Configure the properties for GCP, MySQL, and Hibernate.

**Note:** Currently, we are connecting to GCP Cloud SQL using the MySQL connector. However, we also have the option to use Cloud Proxy or GCP Spring Starter alternatives.
