
import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



public class test extends JFrame {

    private static final long serialVersionUID = 1L;
    
    public test(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        // This will create the dataset
        XYDataset dataset = createDataset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 500));
        // add it to our application
        setContentPane(chartPanel);

    }

    /**
     * Creates a sample dataset
     */
    private XYDataset createDataset() {
        
        final XYSeries series1 = new XYSeries("Points");
        
        for (int i = 0 ; i < Main.X.length ; i ++) {
        	series1.add(Main.X[i], Main.Y[i]);
        }
        
        final XYSeries series2 = new XYSeries("Droite de regression");
        float max = Main.X[0];
        float min = Main.X[0];
        for (float i : Main.X) {
        	if(i<min) {
        		min = i;
        	}
        	
        	if(i > max) {
        		max = i;
        	}
        }
        float x = min;
        while(x < max) {
        	 series2.add(x, Main.a * x + Main.b);
        	 x = (float) (x + 0.1);
        }
       


        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
                
        return dataset;
        
    }
    /**
     * Creates a chart
     */
 private JFreeChart createChart(final XYDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "lineaire",      // chart title
            "X",                      // x axis label
            "Y",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
  //      legend.setDisplaySeriesShapes(true);
        
        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false); // 1 pour relier les points 
        renderer.setSeriesShapesVisible(1, false); // 1 pour afficher chaques points 
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.
                
        return chart;
        
    }

}