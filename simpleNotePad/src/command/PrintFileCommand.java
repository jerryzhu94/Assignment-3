package command;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import component.JTextPaneWithHistory;

public class PrintFileCommand extends JMenuItem implements Command{

	public PrintFileCommand(String text) {
		super(text);
	}
	
	@Override
	public void execute(JTextPaneWithHistory display) {
        try{
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            printerJob.setJobName("Sample Command Pattern");
            printerJob.setCopies(1);
            printerJob.setPrintable(new Printable() {
                public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
                    if (pageIndex > 0)
                        return Printable.NO_SUCH_PAGE;
                    graphics.drawString(display.getText(), 500, 500);
                    paint(graphics);
                    return Printable.PAGE_EXISTS;
                }
            });

            if (printerJob.printDialog() == false)
                return;
            printerJob.print();
        } catch (PrinterException printerException) {
            JOptionPane.showMessageDialog(null,
                    "Printer error" + printerException, "Printing error",
                    JOptionPane.ERROR_MESSAGE);
        }
	}
}
