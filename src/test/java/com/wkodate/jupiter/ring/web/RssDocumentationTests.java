package com.wkodate.jupiter.ring.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wkodate.jupiter.ring.domain.Rss;
import com.wkodate.jupiter.ring.service.RssService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wkodate on 2018/02/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/data.sql")
public class RssDocumentationTests {

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RssService rssService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void getRssesTest() throws Exception {
        this.mockMvc.perform(get("/rss/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("[0].id").value(1))
                .andExpect(jsonPath("[0].feedUrl").value("url1"))
                .andExpect(jsonPath("[0].title").value("title1"))
                .andExpect(jsonPath("[0].siteUrl").value("site-url1"))
                .andExpect(jsonPath("[0].description").value("description1"))
                .andDo(document("index",
                        responseFields(
                                fieldWithPath("[0].id").description("ID"),
                                fieldWithPath("[0].feedUrl").description("Feed URL"),
                                fieldWithPath("[0].title").description("Title"),
                                fieldWithPath("[0]siteUrl").description("website URL"),
                                fieldWithPath("[0].description").description("Description"),
                                fieldWithPath("[0].created").description("Created date"),
                                fieldWithPath("[0].updated").description("Updated date"))));
    }

    @Test
    public void getRssTest() throws Exception {
        this.mockMvc.perform(get("/rss/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("feedUrl").value("url1"))
                .andExpect(jsonPath("title").value("title1"))
                .andExpect(jsonPath("siteUrl").value("site-url1"))
                .andExpect(jsonPath("description").value("description1"))
                .andDo(document("index",
                        pathParameters(parameterWithName("id").description("ID")),
                        responseFields(
                                fieldWithPath("id").description("ID"),
                                fieldWithPath("feedUrl").description("Feed URL"),
                                fieldWithPath("title").description("Title"),
                                fieldWithPath("siteUrl").description("website URL"),
                                fieldWithPath("description").description("Description"),
                                fieldWithPath("created").description("Created date"),
                                fieldWithPath("updated").description("Updated date"))));
    }

    @Test
    public void postRssTest() throws Exception {
        Rss rss = new Rss();
        rss.setId(2L);
        rss.setFeedUrl("post-url");
        rss.setTitle("post");
        this.mockMvc.perform(post("/rss/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(rss)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").value(2))
                .andExpect(jsonPath("title").value("post"))
                .andExpect(jsonPath("feedUrl").value("post-url"))
                .andDo(document("index",
                        requestFields(
                                fieldWithPath("id").description("ID"),
                                fieldWithPath("feedUrl").description("Feed URL"),
                                fieldWithPath("title").description("Title"),
                                fieldWithPath("siteUrl").description("website URL"),
                                fieldWithPath("description").description("Description"),
                                fieldWithPath("created").description("Created date"),
                                fieldWithPath("updated").description("Updated date"))));
    }

}