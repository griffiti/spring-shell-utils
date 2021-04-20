package net.griffiti.shell.table;

import java.util.List;

/**
 *
 * @author domagoj on 20.06.2018
 */
public interface TableDataSource {

    int size();

    List<String> getRowElements(int rowNumber);

}
