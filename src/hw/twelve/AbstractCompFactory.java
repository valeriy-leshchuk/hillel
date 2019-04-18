package hw.twelve;

import hw.twelve.components.ICheckbox;
import hw.twelve.components.ITooltip;

interface AbstractCompFactory
{
    ICheckbox createCheckbox();

    ITooltip createTooltip();
}