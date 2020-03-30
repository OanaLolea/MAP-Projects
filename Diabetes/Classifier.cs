using System;
using System.Collections.Generic;
using System.Text;

namespace Diabetes
{
    interface Classifier
    {
        void train(List<Instance> ListOfInstances);

        List<int> predict(Instance[] instances);
    }
}
