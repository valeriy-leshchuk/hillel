package hw.twelve;

import hw.twelve.components.ICheckbox;
import hw.twelve.components.ITooltip;
import hw.twelve.components.macOsX.MacOsXCheckbox;
import hw.twelve.components.macOsX.MacOsXTooltip;

public class MacOsXCompCompFactory implements AbstractCompFactory
{
    @Override
    public ICheckbox createCheckbox()
    {
        return new MacOsXCheckbox();
    }

    @Override
    public ITooltip createTooltip()
    {
        return new MacOsXTooltip();
    }
}