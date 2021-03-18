package FINAL;

public class Popular {
    public int getPopularElement(int[] a)
    {
        int 总的出现次数 = 1, 本次出现次数;
        int 最多出现 = a[0];
        int 当前找的数 = 0;

        for (int i = 0; i < (a.length - 1); i++)
        {
            当前找的数 = a[i];
            本次出现次数 = 0;
            for (int j = 1; j < a.length; j++)
            {
                if (当前找的数 == a[j])
                    本次出现次数++;
            }
            if (本次出现次数 > 总的出现次数)
            {
                最多出现 = 当前找的数;
                总的出现次数 = 本次出现次数;
            }
        }
        return 最多出现;
    }
}
