using System;
using System.Collections.Generic;

namespace Diabetes
{
    class Program
    {
        static List<Instance> readFile(string fileName)

        {
            List<Instance> instances = new List<Instance>();
            string[] lines = System.IO.File.ReadAllLines(fileName);
            foreach(string line in lines)
            {
                Instance i = new Instance(line);
                instances.Add(i);

            }
            return instances;
        }

        static void Main(string[] args)
        {
            List<Instance> instances = new List<Instance>();

            instances = readFile("pima.csv");

            KNN c = new KNN(5);

            List<Instance> newInstances = new List<Instance>();
            for (int i = 0; i < 700; i++)
                newInstances.Add(instances[i]);
            c.train(newInstances);

            Instance i1 = instances[10];

            

            Console.WriteLine(c.predictOne(i1));
        }
    }
}
