# CRC Cards Explanation

TaskManager collaborates with Task because it is responsible for storing, retrieving, and managing Task objects. This requires direct interaction with them. Its responsibilities include adding tasks, finding tasks by ID, and filtering tasks by status.

Task does not collaborate with TaskManager because its responsibilities are limited to storing its own data and updating its own status. It operates independently and does not need awareness of how tasks are managed or stored.