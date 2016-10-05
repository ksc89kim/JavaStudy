import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FileUtils {

	public String _fileString;
	public File _file;
	public void createJavaFile(String fileName) throws IOException
	{
		_file = new File("files/java/"+fileName+".java");
        // creates the file
		_file.createNewFile();
        // creates a FileWriter Object
        // Writes the content to the file
        _fileString = "import java.util.HashMap;\n\n public class "+ fileName + "\n{\n"
        		+ "\t private HashMap<String, String> _map;\n" + "\t private static "+fileName+" _instance;\n\n"
        		+ "\tpublic static "+fileName+" getInstance() { \n"+"\t\t if (_instance == null) \n"+
        		"\t\t { _instance = new "+fileName+"();_instance.createData();} \n" +
        		"\t\t return _instance;\n\t}\n\n" + "\tpublic String getImageBase64String(String imageName)\n\t{\n"+
        		"\t\t return _map.get(imageName);\n\t}\n\n"+"\tpublic void createData()\n\t{\n\t\t "+
        		"_map = new HashMap<String, String>();\n";
        

	}
	
	public void addImageString(String imageName, String imageData)
	{
		_fileString += "\t\t _map.put(\""+imageName+"\", \""+imageData+"\");\n";
	}
	
	public void closeJavaFile() throws IOException
	{
		_fileString += "\t}\n}";
        FileWriter writer = new FileWriter(_file); 
        writer.write(_fileString); 
        writer.flush();
        writer.close();
	}
}
