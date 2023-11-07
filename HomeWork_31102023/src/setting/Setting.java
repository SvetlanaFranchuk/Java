package setting;

import java.util.ArrayList;
import java.util.List;

public class Setting {
  private final String sortMode;
  private final String dateType;
  private final String fileName;
  private List<String> listNextFile = new ArrayList<>();

  public Setting(String sortMode, String dateType, String fileName, List<String> listNextFile) {
    if (sortMode == null) this.sortMode= "-a";
    else this.sortMode = sortMode;
    this.dateType = dateType;
    this.fileName = fileName;
    this.listNextFile = listNextFile;
  }

  public String getSortMode() {
    return sortMode;
  }

  public String getDateType() {
    return dateType;
  }

  public String getFileName() {
    return fileName;
  }

  public List<String> getListNextFile() {
    return listNextFile;
  }

  @Override
  public String toString() {
    return "setting.Setting{" +
            "sortMode='" + sortMode + '\'' +
            ", dateType='" + dateType + '\'' +
            ", fileName='" + fileName + '\'' +
            ", ListNextFile=" + listNextFile +
            '}';
  }
}
//a. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
//b. тип данных (-s или -i), обязательный;
//c. имя выходного файла, обязательное;
//d. остальные параметры – имена входных файлов, не менее одного.