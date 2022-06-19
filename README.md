# SpringProject
## Spring + MySQL 기능 구현하기
### 1. 회원 관리 기능 구현
1) UserController(Join / Login)
   1) JWT 발급 및 반환
2) UserService
   1) UserServiceImpl
      1) Join
      2) Login
3) UserRepository(DAO) - JPA - MySQL 연결
4) Data
   1) User(Entity)
   2) JoinRequest / LoginRequest --> UserRequest로 통합(ID, PW)
      1) JoinRequest(ID, PW, NAME)
      2) LoginRequest(ID, PW)
   3) UserDTO(User에게 반환하는 Data Object)
      1) UserDTO(NAME , FRIEND_LIST)
         1) searchFriends : 친구리스트 불러와서 반환




### 2. 친구 관리 기능 구현
