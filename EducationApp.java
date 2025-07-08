import java.util.ArrayList;
import java.util.List;

interface LearningModule {
    void create();
    void integrate();
    void access();
}

// Concrete components
class VideoCourse implements LearningModule {
    public void create() {
        System.out.println("Creating video course...");
    }

    public void integrate() {
        System.out.println("Integrating video course...");
    }

    public void access() {
        System.out.println("Accessing video course...");
    }
}

class QuizModule implements LearningModule {
    public void create() {
        System.out.println("Creating quiz module...");
    }

    public void integrate() {
        System.out.println("Integrating quiz module...");
    }

    public void access() {
        System.out.println("Accessing quiz module...");
    }
}

class TutorialModule implements LearningModule {
    public void create() {
        System.out.println("Creating tutorial module...");
    }

    public void integrate() {
        System.out.println("Integrating tutorial module...");
    }

    public void access() {
        System.out.println("Accessing tutorial module...");
    }
}

// Composite
class CompositeModule implements LearningModule {
    private List<LearningModule> modules = new ArrayList<>();

    public void addModule(LearningModule module) {
        modules.add(module);
    }

    public void create() {
        for (LearningModule m : modules) m.create();
    }

    public void integrate() {
        for (LearningModule m : modules) m.integrate();
    }

    public void access() {
        for (LearningModule m : modules) m.access();
    }
}

// Factory
abstract class LearningModuleFactory {
    public abstract LearningModule createModule();
}

class VideoCourseFactory extends LearningModuleFactory {
    public LearningModule createModule() {
        return new VideoCourse();
    }
}

class InteractiveLearningFactory extends LearningModuleFactory {
    public LearningModule createModule() {
        CompositeModule composite = new CompositeModule();
        composite.addModule(new QuizModule());
        composite.addModule(new TutorialModule());
        return composite;
    }
}

// Demo
public class EducationApp {
    public static void main(String[] args) {
        LearningModuleFactory videoFactory = new VideoCourseFactory();
        LearningModule video = videoFactory.createModule();
        video.create();
        video.integrate();
        video.access();

        LearningModuleFactory interactiveFactory = new InteractiveLearningFactory();
        LearningModule interactive = interactiveFactory.createModule();
        interactive.create();
        interactive.integrate();
        interactive.access();
    }
}
