package com.walye.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.walye.controller.UserController;
import com.walye.entity.User;
import com.walye.service.AopService;
import com.walye.service.IUserService;
import com.walye.service.QuestionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml",
		"classpath:spring-servlet.xml" })
@Transactional
public class mytest {

	@Resource
	AopService aopService;

	@Mock
	IUserService mockuserService;

	@Resource
	IUserService userService;

	@InjectMocks
	QuestionService questionService;

	@Resource
	UserController userController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testAop() {
		aopService.doAop();
	}

	@Test
	public void testfind() {
		when(mockuserService.findUserById(1)).thenReturn(
				new User(1, "zhuweiqiang"));
		User user = questionService.findUserById(1);
		Assert.assertEquals(new User(1, "zhuweiqiang"), user);
	}

	@Test
	public void mockhttp() {
		HttpServletRequest request = new MockHttpServletRequest("GET",
				"/finduser");
		HttpServletResponse response = new MockHttpServletResponse();
		ModelAndView mv = userController.finduser(request, response, 1);
		ModelAndViewAssert.assertViewName(mv, "/success");
		ModelAndViewAssert.assertModelAttributeValue(mv, "user", new User(1,
				"zhuweiqiang1"));
	}

	@Test
	public void mockmvc() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController)
				.build();
		mockMvc.perform(get("/finduser?id=1"))
				.andExpect(handler().handlerType(UserController.class))
				.andExpect(handler().methodName("finduser"))
				.andExpect(model().hasNoErrors())
				.andExpect(view().name("/success"))
				.andExpect(
						model().attribute("user", new User(1, "zhuweiqiang1")));
	}

	@Test
	public void testadd() {
		User user = new User("zhuweiqiang2");
		long newid = userService.addUser(user);
		Assert.assertNotNull(newid);
		User newuser = userService.findUserById(newid);
		Assert.assertSame(user, newuser);

	}

	@Repeat(1)
	@Test(timeout=2000)
	public void testtimeout() throws InterruptedException {
		System.out.println("----");
		Thread.sleep(1*1000);
	}
}