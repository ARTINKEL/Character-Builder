package edu.bsu.cs222.model;

import java.io.*;

public class ContentCreator {
    public Response createResponse(String response) {
        return new Response(response);
    }

    public String getFileContent(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String fileText = null;
        while (reader.readLine() != null) {
            fileText += reader.readLine();
        }
        reader.close();
        return fileText;
    }

}
