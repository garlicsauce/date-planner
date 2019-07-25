package io.garlicsauce.dateplanner.api

import io.garlicsauce.dateplanner.boundary.ImportantDates
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class ImportantDatesControllerUT extends Specification {

    private ImportantDates importantDatesMock = Mock()

    @Subject
    private ImportantDatesController controller = new ImportantDatesController(importantDatesMock)

    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build()

    def "POST /cases with proper body should respond with 201 CREATED"() {
        when:
            def call = mockMvc.perform(post("/importantDates")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content('''
                        {
                            "name": "first kiss",
                            "date": "2010-01-31"
                        }
                    '''))

        then:
            call.andExpect(status().isCreated())
    }

    @Unroll
    def "POST /cases with missing properties should respond with 400 BAD REQUEST"() {
        when:
            def call = mockMvc.perform(post("/importantDates")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(requestBody))

        then:
            call.andExpect(status().isBadRequest())

        where:
            requestBody << [
                    '{ "date": "2010-01-31" }',
                    '{ "name": null, "date": "2010-01-31" }',
                    '{ "name": "", "date": "2010-01-31" }',
                    '{ "name": "first kiss" }',
                    '{ "name": "first kiss", "date": null }'
            ]
    }
}
