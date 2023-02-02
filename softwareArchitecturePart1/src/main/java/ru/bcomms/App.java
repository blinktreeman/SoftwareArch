package ru.bcomms;

import ru.bcomms.inMemoryModel.AnotherSceneObserver;
import ru.bcomms.inMemoryModel.ModelStore;
import ru.bcomms.inMemoryModel.SceneObserver;
import ru.bcomms.modelElements.*;

import java.awt.image.BufferedImage;

public class App 
{
    public static void main( String[] args )
    {
        Polygon polygon = new Polygon(new Point3D());
        polygon.addPoint(new Point3D(1, 2, 3));
        polygon.addPoint(new Point3D(4, 5, 6));

        Texture texture = new Texture("myNewTexture",
                new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB));

        PolygonalModel polygonalModel = new PolygonalModel();
        polygonalModel.addPolygon(polygon);
        polygonalModel.addTexture(texture);

        Flash flash = new Flash(new Point3D(), new Angle3D(), Color.green, 100);

        Camera camera = new Camera(new Point3D(), new Angle3D());

        Scene scene = new Scene(polygonalModel, camera);
        scene.addFlash(flash);

        ModelStore modelStore = new ModelStore(scene);

        SceneObserver observer = new SceneObserver();
        AnotherSceneObserver anotherObserver = new AnotherSceneObserver();
        modelStore.registerModelChanger(observer);
        modelStore.registerModelChanger(anotherObserver);

        Scene newScene = new Scene(polygonalModel, camera);
        modelStore.addScene(newScene);
        /*
        Output:
        Something changed in ru.bcomms.inMemoryModel.SceneObserver
        Something changed in ru.bcomms.inMemoryModel.AnotherSceneObserver
         */
        modelStore.removeScene(scene);
        /*
        Output:
        Something changed in ru.bcomms.inMemoryModel.SceneObserver
        Something changed in ru.bcomms.inMemoryModel.AnotherSceneObserver
         */
    }
}
