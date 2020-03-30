using System;
using System.Collections.Generic;
using System.Text;
using System.Windows;
using System.Numerics;
using System.Linq;

namespace Diabetes
{
    class KNN: Classifier
    {
        private int k;

        private List<Instance> ListOfInstances;
        public KNN(int k)
        {
            this.k = k;
        }

        public int K { get; set; }

        public int predictOne(Instance inst)
        {
            List<double> minimumDistances = new List<double>();
            List<Instance> correspInstances = new List<Instance>();


            foreach(Instance i in ListOfInstances)
            {
                double dist = Math.Sqrt((i.Input[0] - inst.Input[0]) *(i.Input[0] - inst.Input[0]) + (i.Input[1] - inst.Input[1]) *(i.Input[1] - inst.Input[1]) + (i.Input[2] - inst.Input[2]) *(i.Input[2] - inst.Input[2])+(i.Input[3] - inst.Input[3]) * (i.Input[3] - inst.Input[3]) + (i.Input[4] - inst.Input[4]) *(i.Input[4] - inst.Input[4]) + (i.Input[5] - inst.Input[5]) * (i.Input[5] - inst.Input[5]) + (i.Input[6] - inst.Input[6]) * (i.Input[6] - inst.Input[6]) + (i.Input[7] - inst.Input[7]) * (i.Input[7] - inst.Input[7]));
                double minimum = Enumerable.Min(minimumDistances);
                if(dist<minimum)
                    if(minimumDistances.Capacity < k)
                    {
                        minimumDistances.Add(dist);
                        correspInstances.Add(i);
                    }
                    else
                        if(minimumDistances.Capacity == k)
                        {
                            minimumDistances.Remove(Enumerable.Max(minimumDistances));
                            correspInstances.RemoveAt(0);
                            minimumDistances.Add(dist);
                            correspInstances.Add(i);
                    }
            }

            int countZeros = 0;
            int countOnes = 0;
            for(int i = 0; i < minimumDistances.Count; i++)
            {
                if (correspInstances[i].Output == 1)
                    countOnes++;
                else
                    countZeros++;
            }
            
            return Math.Max(countZeros, countOnes);
        }

        public void train(List<Instance> instances)
        {
            this.ListOfInstances = instances;
        }

        public List<int> predict(Instance[] instances)
        {
            throw new NotImplementedException();
        }
    }
}
