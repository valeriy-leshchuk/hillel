package hw.twelve;

import hw.twelve.components.ICheckbox;
import hw.twelve.components.ITooltip;
import hw.twelve.factory.MacOsXCompCompFactory;
import hw.twelve.factory.WinCompCompFactory;

public class DemoApp
{
    public static void main(String[] args)
    {
        MacOsXCompCompFactory macFactory = new MacOsXCompCompFactory();
        WinCompCompFactory winFactory = new WinCompCompFactory();

        ICheckbox macCheckBox = macFactory.createCheckbox();
        ITooltip macTooltip = macFactory.createTooltip();

        ICheckbox winCheckBox = winFactory.createCheckbox();
        ITooltip winTooltip = winFactory.createTooltip();

        macCheckBox.paint();
        macTooltip.paint();
        winCheckBox.paint();
        winTooltip.paint();
    }
}