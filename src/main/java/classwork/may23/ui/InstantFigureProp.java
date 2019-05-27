package classwork.may23.ui;

import lombok.Getter;
import lombok.Setter;

public final class InstantFigureProp
{
    public enum Shape {Rectangle, Oval}

    @Getter private static final InstantFigureProp instance = new InstantFigureProp();
    @Setter @Getter private Shape shape;
    @Setter @Getter private boolean isFilled;

    private InstantFigureProp()
    {}
}