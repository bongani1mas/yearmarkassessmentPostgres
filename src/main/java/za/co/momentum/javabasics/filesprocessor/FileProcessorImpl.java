package za.co.momentum.javabasics.filesprocessor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProcessorImpl implements FileProcessor {

    @Override
    public String[] readFileData(String fileLocation) {
        BufferedReader reader;
        List<String> studentDataList = new ArrayList<String>();
        int count = 0;
        try {
            reader = new BufferedReader(new FileReader(fileLocation));
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                // read next line
                line = reader.readLine();
                studentDataList.add(line); //store record into String Array
                count++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] studentData = studentDataList.toArray(new String[studentDataList.size()]);
        ;

        return studentData;
    }
}
