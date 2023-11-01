import java.util.ArrayList;
import java.util.List;

public class Setting {
  private String sortMode = "-a";
  private String dateType;
  private String fileName;
  private List<String> ListNextFile = new ArrayList<>();

  public Setting() {
  }

  public String getSortMode() {
    return sortMode;
  }

  public void setSortMode(String sortMode) {
    this.sortMode = sortMode;
  }

  public String getDateType() {
    return dateType;
  }

  public void setDateType(String dateType) {
    this.dateType = dateType;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

   public void setListNextFile(String listNextFile) {
    ListNextFile.add(0, listNextFile);
  }

  public List<String> getListNextFile() {
    return ListNextFile;
  }

  @Override
  public String toString() {
    return "Setting{" +
            "sortMode='" + sortMode + '\'' +
            ", dateType='" + dateType + '\'' +
            ", fileName='" + fileName + '\'' +
            ", ListNextFile=" + ListNextFile +
            '}';
  }
}
//a. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
//b. тип данных (-s или -i), обязательный;
//c. имя выходного файла, обязательное;
//d. остальные параметры – имена входных файлов, не менее одного.