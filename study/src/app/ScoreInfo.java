package app;

class ScoreInfo implements Comparable<ScoreInfo>
{
    private int score;
    private long date;

    public ScoreInfo(int score,long date)
    {
        this.score=score;
        this.date=date;
    }
    public String toString()
    {
        return ""+score+" "+date;
    }
    public int compareTo(ScoreInfo other)
    {
        if(score != other.score)
            return other.score-score;
        else
        return (int)(date=other.date);
    }
}