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
        z_ = ls2.set_to_pair();
        z_ = ls2.set_first(n);
        z_ = ls2.set_rest(ls);

        return ls2;
    }

    public List make_nil()
    {
        List ls;

        ls = new List();
        z_ = ls.set_to_nil();

        return ls;
    }
}


class List
{
    int z_;
    boolean is_null;
    int first;
    List rest;

    public boolean is_null() {return is_null;}

    public int set_to_nil() {is_null = true; return 0;}
    public int set_to_pair() {is_null = false; return 0;}

    public int set_first(int n) {first = n; return 0;}
    public int set_rest(List ls) {rest = ls; return 0;}

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

    public int length_()
    {
        int len;

        if (is_null)
            len = 0;
        else
            len = rest.length_() + 1;

        return len;
    }
}
