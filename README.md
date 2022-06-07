# SpringProject
## Spring + MySQL 기능 구현하기
### 1. 회원 관리 기능 구현
1) UserController(Join / Login)
2) UserService
   1) UserServiceImpl
3) UserRepository(DAO) - JPA - MySQL 연결
4) Data
   1) User(Entity)
   2) JoinRequest / LoginRequest --> UserRequest로 통합(email, password)
   5) UserDTO(User에게 반환하는 Data Object)

### 2. 친구 관리 기능 구현
