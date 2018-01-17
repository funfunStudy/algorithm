using Xunit;
using System.Collections.Generic;

public class RGBTest
{
    [Fact]
    public void Rgb_distance_case1()
    {
        var rgbList = new List<int[]>(){
            (new int[]{26, 40, 83}),
            (new int[]{49, 60, 57}),
            (new int[]{13, 89, 99})
        };

        var rgb = new RGB(rgbList);
        Assert.Equal(96, rgb.MinimumValue());
    }

    [Fact]
    public void Rgb_distance_case2()
    {
        var rgbList = new List<int[]>(){
            (new int[]{1, 20, 30}),
            (new int[]{50, 5, 6}),
            (new int[]{9, 3, 7})
        };

        var rgb = new RGB(rgbList);
        Assert.Equal(10, rgb.MinimumValue());
    }
}
