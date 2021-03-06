package jpa.practice.repository;

import jpa.practice.domain.Address;
import jpa.practice.domain.Gender;
import jpa.practice.domain.User;
import jpa.practice.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHistoryRepository userHistoryRepository;


    @Test
    public void embedTest() {
        userRepository.findAll().forEach(System.out::println);

        User user = new User();
        user.setName("spammy");
        user.setHomeAddress(new Address("성남시", "위례동", "위례어딘가", "123456"));
        user.setCompanyAddress(new Address("서울시", "공덕역", "공덕사거리", "123456"));

        userRepository.save(user);

        User user1 = new User();
        user1.setName("GuGu");
        user1.setHomeAddress(null);
        user1.setCompanyAddress(null);

        userRepository.save(user1);

        User user2 = new User();
        user2.setName("boomkin");
        user2.setHomeAddress(new Address());
        user2.setCompanyAddress(new Address());

        userRepository.save(user2);

        userRepository.findAll().forEach(System.out::println);
        userHistoryRepository.findAll().forEach(System.out::println);

        assertAll(
                () -> assertThat(userRepository.findById(7L).get().getHomeAddress()).isNull(),
                () -> assertThat(userRepository.findById(8L).get().getHomeAddress()).isInstanceOf(Address.class),
                () -> assertThat(userRepository.findById(9L).get().getHomeAddress()).isInstanceOf(Address.class)
        );

    }

    @Test
    void crud(){
//        userRepository.save(User.builder()
//                                .name("구마적")
//                                .build()
//                            );

        userRepository.findAll().forEach(System.out::println);

    }

    @Test
    void exist(){
        boolean exists = userRepository.existsById(1L);

        System.out.println(exists);
    }

    @Test
    void delete(){
//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
        userRepository.deleteById(1L);
        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L,3L))); //select 절이 실행되고 entity의 유무를 확인후 삭제
        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L,3L))); //select 절 없이 바로 eneity의 삭제쿼리를 날리는 방법
        userRepository.deleteAllInBatch();

    }

    @Test
    void page(){
        Page<User> users = userRepository.findAll(PageRequest.of(0,3)); //zero-base paging

        System.out.println("page : " + users);
        System.out.println("totalElements : " + users.getTotalElements());
        System.out.println("totalPages : " + users.getTotalPages());
        System.out.println("numberOfElements : " + users.getNumberOfElements());
        System.out.println("sort : " + users.getSort());
        System.out.println("size : " + users.getSize());

        users.getContent().forEach(System.out::println);
    }

    @Test
    void QBE(){
//        ExampleMatcher matcher =  ExampleMatcher.matching()
//                .withIgnorePaths("id")
//                .withMatcher("name", endsWith());
//        Example<User> example = Example.of(new User("동"), matcher);

        User user = new User();
        user.setName("길");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name",contains());
        Example<User> example  = Example.of(user,matcher);


        userRepository.findAll(example).forEach(System.out::println);

    }

    @Test
    void select(){
//        System.out.println(userRepository.findByName("갑수"));

//        System.out.println("getByName : " + userRepository.getByName("덕배"));
//        System.out.println("getByName : " + userRepository.readByName("덕배"));
//        System.out.println("getByName : " + userRepository.queryByName("덕배"));
//        System.out.println("getByName : " + userRepository.searchByName("덕배"));
//        System.out.println("getByName : " + userRepository.streamByName("덕배"));
//        System.out.println("getByName : " + userRepository.findUserByName("덕배"));

//        System.out.println("findFirst2Name : " + userRepository.findFirst2ByName("갑수"));
//        System.out.println("findTop3Name : " + userRepository.findTop3ByName("갑수"));
//        System.out.println("findByNameAndId : " + userRepository.findByNameAndId("갑수",6L));
//        System.out.println("findByNameOrId : " + userRepository.findByNameOrId("갑수", 1L));
//        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(3L));
//        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now()));

//        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(3L)));
//        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L,5L));
//        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L,5L));

//        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
//        System.out.println("findByAddressIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());

//        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("덕배", "갑수")));
//        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("덕"));
//        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("배"));
//        System.out.println("findByNameContains : " + userRepository.findByNameContains("김"));
        System.out.println("findByNameContains : " + userRepository.findByNameContains("rt"));
        System.out.println("findByNameLike : " + userRepository.findByNameLike("%rt%"));

    }


    @Test
    void userHistoryTest() {
        User user = new User();
        user.setEmail("spammy7147@gmail.com");
        user.setName("spammy");

        userRepository.save(user);

        user.setName("spammy-spammy-spammy");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }


    @Test
    void userRelationTest() {
        User user = new User();
        user.setName("spammy");
        user.setEmail("spammy7147@gmail.com");
        user.setGender(Gender.MALE);

        userRepository.save(user);
        user.setName("spammy1");
        userRepository.save(user);
        user.setEmail("spammy1@gmail.com");
        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
//        System.out.println("userId > " + userRepository.findByEmail("spammy1@gmail.com").getId());
//        List<UserHistory> result = userHistoryRepository.findByUserId(7L);
//        result.forEach(System.out::println);

        List<UserHistory> result = userRepository.findByEmail("spammy1@gmail.com").getUserHistories();
        result.forEach(System.out::println);

        System.out.println("UserHistory.getUser() : " + userHistoryRepository.findAll().get(0).getUser());


    }

}