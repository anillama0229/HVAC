import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


import java.io.IOException;

public class MyDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        String inputFile = "input/firstResult.csv";
        Configuration configuration = new Configuration();
        Job myJob = Job.getInstance(configuration);


        FileInputFormat.setInputPaths(myJob,inputFile);
        FileOutputFormat.setOutputPath(myJob,new Path("secondResult.csv"));


        myJob.setInputFormatClass(TextInputFormat.class);
        myJob.setOutputFormatClass(TextOutputFormat.class);


        myJob.setOutputKeyClass(IntWritable.class);
        myJob.setOutputValueClass(Text.class);

        myJob.setMapperClass(MyMapper.class);
        myJob.setReducerClass(MyReducer.class);

        myJob.setJarByClass(MyDriver.class);
        myJob.setJobName("First Written Job");

        myJob.waitForCompletion(true);

    }
}
