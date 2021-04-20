package net.griffiti.shell.table.ascii;

import java.util.List;

import de.vandermeer.asciitable.AT_ColumnWidthCalculator;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import net.griffiti.shell.table.TableDataSource;
import net.griffiti.shell.table.TableRenderer;

/**
 * @author mgulan on 03.08.18.
 */
public class BasicTableRenderer implements TableRenderer {
    private static final AT_ColumnWidthCalculator DEFAULT_CWC = new CWC_LongestLine();
    public static final int DEFAULT_TABLE_WIDTH=100;

    private AT_ColumnWidthCalculator cwc;
    private int width;

    public BasicTableRenderer() {
        this(DEFAULT_CWC, DEFAULT_TABLE_WIDTH);
    }

    public BasicTableRenderer(int tableWidth) {
        this(DEFAULT_CWC, tableWidth);
    }

    public BasicTableRenderer(AT_ColumnWidthCalculator cwc, int tableWidth) {
        this.cwc = (cwc != null ? cwc : DEFAULT_CWC);
        this.width = tableWidth;
    }

    
    /** 
     * @param headers List of headers to display for table
     * @param tableDataSource Data source for table
     * @return String
     */
    @Override
    public String render(List<String> headers, TableDataSource tableDataSource) {
        AsciiTable at = new AsciiTable();
        at.getRenderer().setCWC(cwc);

        at.addRule();
        at.addRow(headers);
        at.addRule();
        for (int i = 0; i < tableDataSource.size(); i++) {
            at.addRow(tableDataSource.getRowElements(i));
            at.addRule();
        }
        return at.render(width);
    }


    
    /** 
     * @param width Width of rendered table
     */
    // ----- get / set methods -------------------------------------------------------------

    public void setWidth(int width) {
        this.width = width;
    }

    
    /** 
     * @return int
     */
    public int getWidth() {
        return width;
    }

    
    /** 
     * @param cwc Set defined column width calculator
     */
    public void setCwc(AT_ColumnWidthCalculator cwc) {
        this.cwc = cwc;
    }

    
    /** 
     * @return AT_ColumnWidthCalculator
     */
    public AT_ColumnWidthCalculator getCwc() {
        return cwc;
    }
}
