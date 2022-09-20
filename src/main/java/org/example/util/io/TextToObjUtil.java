package org.example.util.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class for reading data from .txt tiles into java objects.
 */
public class TextToObjUtil {

    /**
     * Reads the text file containing matrix of numbers into a List of Lists.
     *
     * @param filePath The filepath of the text file.
     *
     * @return
     */
    public static List<List<Integer>> txtArrayToListOfLists(final String filePath){

        String content;
        try
        {
            content = Files.readString(Path.of(filePath));
        }
        catch (IOException io)
        {
            return Collections.emptyList();
        }

        final var strings = content.split("\n");
        final var xList = new ArrayList<List<Integer>>();
        for(var string : strings)
        {
            final var yList = new ArrayList<Integer>();
            for(var str : string.split(" "))
            {
                yList.add(Integer.parseInt(str));
            }
            xList.add(Collections.unmodifiableList(yList));
        }
        return Collections.unmodifiableList(xList);
    }

}
