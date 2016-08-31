package com.bestxty.ds;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by xty on 2016/8/31.
 * for project: DistributedSystemTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:spring-config.xml", "classpath:spring-mvc.xml"})
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }


    @Test
    public void testAdd() throws Exception {
        mockMvc.perform((post("/user/add").param("token", "test token3"))).andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform((post("/user/get").param("userId", "xty3"))).andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testUpdate() throws Exception {

        mockMvc.perform((post("/user/update").param("userId", "xty3"))).andExpect(status().isOk())
                .andDo(print());
        mockMvc.perform((post("/user/get").param("userId", "xty3"))).andExpect(status().isOk())
                .andDo(print());
    }


}
