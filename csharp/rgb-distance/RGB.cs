using System;
using System.Collections.Generic;
using System.Linq;
using Houses = System.Collections.Generic.IEnumerable<System.Collections.Generic.IEnumerable<int>>;

public class RGB
{
    readonly Houses houses;

    public RGB(Houses rgbList)
    {
        this.houses = rgbList;        
    }

    public int MinimumValue()
    {
        var first = houses.First().ToList(); // 검사할 첫번째 배열을 담는다.
        var remains = houses.Skip(1);  // 첫번째 배열을 제외한다.

        // 첫번째 배열의 RGB 순서대로 검사하면서 리스트에 추가한다.
        // R 기준 최소 값, G 기준 최소 값, B 기준 최소 값 을 구해 최소 값을 리턴한다.
        return (
            from color in first
            select FindMinValue(first.IndexOf(color), color, remains)
        ).Min();
    }

    //rgb = 기준이 되는 R,G,B 타입, price = 최종 비용, list = 검사 될 RGB 배열
    private int FindMinValue(int rgb, int price, Houses list)
    {
        if (list.Count() == 0)
            return price;

        var first = list.First().ToList(); // 검사할 첫번째 배열을 담는다.
        var remains = list.Skip(1);  // 첫번째 배열을 제외한다.

        return (
            from index in Enumerable.Range(rgb + 1, 2).Select(v => v % 3)
            select FindMinValue(index, price + first[index], remains)
        ).Min();
    }
}