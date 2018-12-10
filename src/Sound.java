public class Sound
{
    private int[] samples;

    /**
     *
     * @param theSamples
     */

    public Sound(int[] theSamples)
    {
        samples = theSamples;
    }

    /** Changes those values in this sound that have an amplitude greater than the limit.
     * Values greater than limit changed to limit.
     * Values less than -limit changed to -limit.
     *
     * @param limit the amplitude limit.
     * @return number of values changed.
     */

    public int limitAmplitude(int limit)
    {
        limit = Math.abs(limit);
        int numChanged = 0;
        for (int i = 0; i < samples.length; i++)
        {
            if (samples[i] > limit)
            {
                samples[i] = limit;
                numChanged++;
            }
            else if (samples[i] < -1 * limit)
            {
                samples[i] = limit * -1;
                numChanged++;
            }

        }

        return numChanged;
    }

    public void trimSilenceFromBeginning()
    {
        int startingIndex = 0;
        while (samples[startingIndex] == 0)
        {
            startingIndex++;
        }
        int[] temp = new int[samples.length - startingIndex];
        for (int i = startingIndex; i < samples.length; i++)
        {
            temp[i-startingIndex] = samples[i];
        }
        samples = temp;
    }


    public void trimSilenceFromEnd()
    {
        int startingIndex = samples.length - 1;
        while (samples[startingIndex] == 0)
        {
            startingIndex--;
        }

        int newIndex = samples.length - startingIndex;
        int[] temp = new int[newIndex];
        for (int i = 0; i < temp.length; i++)
        {
            temp[i] = samples[i];
        }
        samples = temp;
    }

    public void padBeginningWithSilence(int numLeadingZeroes)
    {
        int[] temp = new int[samples.length + numLeadingZeroes];
        for (int i = numLeadingZeroes; i < temp.length; i++)
        {
            temp[i] = samples[i - numLeadingZeroes];
        }

        samples = temp;
    }

    public void padEndWithSilence(int numTrailingZeroes)
    {
        int[] temp = new int[samples.length + numTrailingZeroes];
        for (int i = 0; i < samples.length; i++)
        {
            temp[i] = samples[i];
        }

        samples = temp;
    }

    public String toString()
    {
        String output = " ";
        if (samples.length == 0)
        {
            return "No sample sounds";
        }

        if (samples.length == 1)
        {
            return output + samples[0];
        }

        for (int i = 0; i < samples.length - 1; i++)
        {
            output += samples[i] + ", ";
        }

        output += samples[samples.length - 1];

        return output;
    }
}
