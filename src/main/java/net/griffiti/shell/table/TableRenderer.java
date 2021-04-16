package net.griffiti.shell.table;

import java.util.List;

/**
 * @author mgulan on 03.08.18.
 */
public interface TableRenderer {
    String render(List<String> headers, TableDataSource tableDataSource);
}
