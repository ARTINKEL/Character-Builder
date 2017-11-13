package edu.bsu.cs222;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.bsu.cs222.model.Mapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestMapper {

    @Test
    public void testMapper() throws IOException, UnirestException {
        Mapper mapper = new Mapper();
        Assert.assertNotNull(null);
    }

    @Test
    public void testCalculateClassResult_NotNull() throws IOException, UnirestException {
        Mapper mapper = new Mapper();
        String result = mapper.calculateClassResult();
        Assert.assertNotNull(result);
    }

    @Test
    public void testCalculateClassResult_Accuracy() {

    }

    @Test
    public void testCalculateRaceResult_NotNull() throws IOException, UnirestException {
        Mapper mapper = new Mapper();
        String result = mapper.calculateRaceResult();
        Assert.assertNotNull(result);
    }

    @Test
    public void testCalculateRaceResult_Accuracy() {

    }
}
