package com.shf.boot;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * @Author:Su HangFei
 * @Date:2023-01-05 14 12
 * @Project:boot-05-web-admin
 */
@DisplayName("junit5功能测试类")
public class Junit5Test {

    @DisplayName("测试displayname注解")
    @Test
    void testDisplayName() {
        System.out.println(1);
//        System.out.println(jdbcTemplate);
    }

//    @ParameterizedTest
//    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
//    void palindromes(String candidate) {
//        assertTrue(StringUtils.isPalindrome(candidate));
//    }


    @Disabled
    @DisplayName("测试方法2")
    @Test
    void test2() {
        System.out.println(2);
    }

    @RepeatedTest(5)
    @Test
    void test3() {
        System.out.println(5);
    }

    /**
     * 规定方法超时时间。超出时间测试出异常
     *
     * @throws InterruptedException
     */
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(600);
    }

    int cal(int i,int j){
        return i+j;
    }

    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions(){
        int cal = cal(3,2);
        assertEquals(5,cal,"业务逻辑计算失败");
        Object o1 = new Object();
        Object o2 = new Object();
        assertSame(o1,o2,"两个对象不一样");
    }



    @BeforeEach
    void testBeforeEach() {
        System.out.println("测试就要开始了...");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("测试结束了...");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("所有测试就要开始了...");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("所有测试以及结束了...");

    }
}
