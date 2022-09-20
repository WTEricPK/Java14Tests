package org.example.util.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Writing assertions for txt to object read.")
public class TextToObjUtilTest
{


    @Test
    public void textToListOfIntegerLists()
    {

        final List<List<Integer>> matrix = TextToObjUtil.txtArrayToListOfLists(getResourceFilePath("textMatrix.txt"));
        System.out.println(matrix);
    }


    private String getResourceFilePath(final String resourceName)
    {
        // TODO. Replace with class loader implementation.
        final var file = new File("src/test/resources/org/example/util/io/" + resourceName);
        if(!file.exists())
        {
            throw new RuntimeException("File does not exist.");
        }
        return file.getAbsolutePath();
    }

}
