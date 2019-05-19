package hw.twelve.factory;

import hw.twelve.components.ICheckbox;
import hw.twelve.components.ITooltip;
import hw.twelve.components.win.WinCheckbox;
import hw.twelve.components.win.WinTooltip;

public class WinCompCompFactory implements AbstractCompFactory
{
    @Override
    public ICheckbox createCheckbox()
    {
        return new WinCheckbox();
    }

    @Override
    public ITooltip createTooltip()
    {
        return new WinTooltip();
    }
}