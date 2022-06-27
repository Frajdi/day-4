package com.example.day4.mockTest;

import com.example.day4.Day4Application;
import com.example.day4.entities.Spid;
import com.example.day4.entities.enums.Status;
import com.example.day4.service.SpidService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {SpidApplication.class})

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class SpidServiceTest {

    @Mock
    SpidService spidService;

    @BeforeAll
    public void setup() throws Exception {
        Spid spid = new Spid();
        spid.setId(1L);
        spid.setStatus(Status.READY_FOR_REVIEW);

        when(spidService.changeStatus(spid.getId())).thenReturn(spid);
    }

    @Test
    public void testDatabaseRetrievalForSpids() throws Exception {
        Spid spid = new Spid();
        spid.setId(1L);
        spid.setStatus(Status.READY_FOR_REVIEW);
        assertEquals(spid, spidService.changeStatus(spid.getId()));
    }
}
