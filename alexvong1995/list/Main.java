/* Implementation of List.
   Copyright (C) 2018 Alex Vong <alexvong1995@gmail.com>

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */


class Main
{
    public static void main(String[] z_)
    {
        int z2_;
        int n;
        int k;
        int j;
        List ls;

        {
            n = 128;
            k = 0;
            j = 0;
            ls = new U().make_list(n);

            while (k < n)
                {
                    z2_ = ls.list_set(k, -k);
                    k = k + 1;
                }

            while (j < n)
                {
                    System.out.println(ls.list_ref(j));
                    j = j + 1;
                }

            System.out.println(-ls.length_());
        }
    }
}


class U
{
    int z_;

    public List make_list(int n)
    {
        List ls;

        if (!(0 < n))
            ls = this.make_nil();
        else
            ls = this.cons(0, this.make_list(n - 1));

        return ls;
    }

    public List cons(int n, List ls)
    {
        List ls2;

        ls2 = new List();
        z_ = ls2.set_first(n);
        z_ = ls2.set_rest(ls);
        z_ = ls2.set_length(ls.length_() + 1);

        return ls2;
    }

    public List make_nil()
    {
        List ls;

        ls = new List();
        z_ = ls.set_length(0);

        return ls;
    }
}


class List
{
    int z_;
    int first;
    List rest;
    int len;

    public int set_first(int n) {first = n; return 0;}
    public int set_rest(List ls) {rest = ls; return 0;}
    public int set_length(int n) {len = n; return 0;}

    public int list_set(int k, int n)
    {
        if (!(0 < k))
            first = n;
        else
            z_ = rest.list_set(k - 1, n);

        return 0;
    }

    public int list_ref(int k)
    {
        int n;

        if (!(0 < k))
            n = first;
        else
            n = rest.list_ref(k - 1);

        return n;
    }

    public int length_() {return len;}
}
