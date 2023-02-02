using System.Runtime.ExceptionServices;

namespace MyWebApplication.Models
{
    public class WeatherForecastModel
    {
        // Коллекция для храниения показаний температуры
        private List<WeatherForecast> _forecasts;

        public WeatherForecastModel()
        {
            _forecasts = new List<WeatherForecast>();
        }

        public void Add(DateTime date, int temperature) 
        { 
            WeatherForecast weatherForecast = new(date, temperature);
            _forecasts.Add(weatherForecast);
        }

        public void Update(DateTime date, int temperature)
        {
            foreach (WeatherForecast weatherForecast in _forecasts)
            {
                if (weatherForecast.Date == date) 
                {
                    weatherForecast.TemperatureC = temperature;
                    break;
                }
            }
        }

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

        public List<WeatherForecast> GetAll(DateTime fromDate, DateTime toDate) 
        {
            List<WeatherForecast> forecasts = new();
            foreach (WeatherForecast weatherForecast in _forecasts)
            {
                if (weatherForecast.Date >= fromDate && weatherForecast.Date <= toDate)
                {
                    forecasts.Add(weatherForecast);
                }
            }
            return forecasts;
        }

    }
}
