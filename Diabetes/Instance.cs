using System;
using System.Collections.Generic;
using System.Text;

namespace Diabetes
{
    class Instance
    {
        private List<double> input;
        private int output;

        public List<double> Input
        {
            get {
                return this.input;
            } 
   
        }
        
        public int Output
        {
            get;set;
        }

        public Instance(string line)
        {
            string[] arr = line.Split(',');
            this.output = Int32.Parse(arr[arr.Length - 1]);
            this.input = new List<double>();
            for (int i = 0; i < arr.Length - 1; i++)
                this.input.Add(Double.Parse(arr[i]));
        }
    }
}
