DONOR & CHARITY MANAGEMENT SYSTEM 

A full-stack web application built to manage donors, donations, fundraising campaigns, fund allocation, and user accounts in an organized and secure manner.
This system enables charitable organizations to track financial contributions, manage campaigns, and allocate funds efficiently using a structured backend architecture and a clean frontend interface. 



  

<img width="1920" height="957" alt="CharityProject img" src="https://github.com/user-attachments/assets/39a9d558-8152-4fde-9bcf-05788a040206" />

LIVE DEMO :https://donorandcharitymanagementsystem-production-3c6e.up.railway.app/


🚀 Features:

🔐 Authentication & Security:
1. Secure user registration and login
2. Role-based access control using Spring Security
3. Protected REST APIs


👤 User Management:
1. Create and manage system users
2. Secure login/logout functionality


💰 Donor Management:
1. Add new donors
2. Update donor details
3. View donor records
4. Delete donors


💳 Donation Management:
1. Record donations
2. Track donation history
3. View donation reports


🎯 Campaign Management:
1. Create and manage fundraising campaigns
2. Update campaign details
3. Monitor campaign progress


📊 Fund Allocation:
1. Allocate donations to campaigns
2. Maintain allocation records
3. Ensure structured fund distribution


📈 Dashboard:
1. Clean and responsive UI
2. Easy navigation between modules



🧰 Technology Stack :

Backend:
* Java
* Spring Boot
* Spring Security
* JPA / Hibernate
* MySQL
* Maven


Frontend:
* HTML
* CSS
* JavaScript

Development Tools:
- IntelliJ IDEA
- Git & GitHub

🏗️ Project Architecture :

backend:

 1. controller
 2. service
 3. repository
 4. odels
 5. dto
 6. exception
 7. security


frontend:

 1. index.html
 2. css/
 3. js/



The backend follows a layered architecture:

- Controller → Handles HTTP requests
- Service → Business logic
- Repository → Database interaction
- Security → Authentication & authorization



⚙️ Installation & Setup :

1️⃣ Database Setup:
Create a MySQL database:

2️⃣ Run Backend:
mvn spring-boot:run

Backend will start on:
http://localhost:8080

3️⃣ Run Frontend:
Open index.html in your browser.



📘 Sample API Endpoints:

- Method	Endpoint	Description
1. POST	/users	Create new user
2. GET	/donors/{id}	Get donor by ID
3. GET	/donations	Get all donations
4. PUT	/campaigns/{id}	Update campaign
5. DELETE	/fund-allocations/{id}	Delete fund allocation


🔐 Security Implementation:
* Spring Security for authentication
* Password encryption
* Protected REST endpoints
* Role-based authorization


📊 Key Highlights:
* Clean layered backend architecture
* RESTful API design
* Database integration with JPA/Hibernate
* Secure authentication system
* Modular and maintainable codebase


🔮 Future Enhancements:
* Admin dashboard analytics
* Payment gateway integration
* Email notifications
* Cloud deployment
* Docker containerization
* Swagger API documentation

LIVE DEMO : https://donorandcharitymanagementsystem-production-3c6e.up.railway.app/



📌 Author -

Masthan Sharif Shaik

GitHub: https://github.com/MasthanSharifShaik
