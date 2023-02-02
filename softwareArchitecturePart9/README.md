# MyWebApplication

## Задание

Доработать метод Delete на уровне модели данных и контроллера

----

## Реализация

Для реализации метода Delete выполняем:

----

В классе WeatherForecastModel реализуем метод Delete

```csharp
public bool Delete(DateTime date)
{
    var forecastsByDate = from forecast in _forecasts
                          where forecast.Date == date
                          select forecast;
    WeatherForecast weatherForecast = forecastsByDate.FirstOrDefault();
    if (weatherForecast != null)
    {
        return _forecasts.Remove(weatherForecast);
    }
    return false;
}
```

----

В контроллере WeatherForecastController реализуем метод Delete

```csharp
[HttpDelete("delete")]
public ActionResult<Boolean> Delete(DateTime date)
{
    bool deleteResult = _weatherForecastModel.Delete(date);
    return Ok(deleteResult);
}
```

----

При удачном результате удаления возвращаем true, иначе false

