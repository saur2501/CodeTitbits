//important to note that jupyter notebook already supports transformation and there exists an API for Py to Ipynb - but this was a good practice.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;*/

public class Pynb2Py {
	/*private static BufferedWriter bw = null;
	public static void main(String[] args) throws IOException {
		JSONParser jsonParser = new JSONParser();
		File dir2Read = new File("C:\\Users\\I341365\\Desktop\\PIES\\I\\Subjectwise\\ML\\Coursera\\DL\\Gurpradeep+Code+Papers\\deeplearning.ai-Assignments\\Neural-networks-Deep-learning\\Week2");//C:\\Users\\I341365\\Desktop\\PIES\\I\\Curiosities\\Experimentation\\g");
		File dir2Write = new File(dir2Read.getAbsolutePath() + "1");
		String[] paths = dir2Read.list();
		File file2Read = null;
		for(String filename : paths){
			String[] fileNameParts = filename.split("\\.");
			if(fileNameParts[fileNameParts.length - 1].equals("ipynb")) {
				bw = new BufferedWriter(new FileWriter(dir2Write.getAbsolutePath() + "\\" + fileNameParts[0] + ".py"));
				file2Read = new File(dir2Read.getAbsolutePath() + "\\" + filename);
				try (FileReader fileReader = new FileReader(file2Read))
		        {
		            //Read JSON file
		            Object obj = jsonParser.parse(fileReader);
		 
		            JSONObject jsonObject = (JSONObject) obj;
		            //System.out.println(jsonObject);
		            JSONArray cells = (JSONArray) jsonObject.get("cells");
		            cells.forEach(cell -> {
						try {
							writeCellCode( (JSONObject) cell);
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (ParseException e) {
		            e.printStackTrace();
		        } finally {
		        	bw.close();
		        }
			}
		}
    }
	private static void writeCellCode(JSONObject cell) throws IOException {
		if(cell.get("cell_type").equals("code")) {
			JSONArray codeSource = (JSONArray) cell.get("source");
			//System.out.print(codeSource);
			for(int i = 0;i < codeSource.size();i++) {
				bw.write((String) codeSource.get(i));
				System.out.print(codeSource.get(i));
			}
			System.out.println();
			bw.write("\r\n");
		}
	}*/
}
