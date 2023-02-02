using Microsoft.AspNetCore.Mvc;
using MyWebApplication.Models;

namespace MyWebApplication.Controllers
{
    [Route("weather")]
    [ApiController]
    public class WeatherForecastController : ControllerBase
    {
        private WeatherForecastModel _weatherForecastModel;
        public WeatherForecastController(WeatherForecastModel weatherForecastModel) 
        {
            _weatherForecastModel = weatherForecastModel;
        }


        [HttpPost("add")]
        public IActionResult Add(DateTime date, int temperature)
        {
            _weatherForecastModel.Add(date, temperature);
            return Ok();
        }

        [HttpPut("update")]
        public IActionResult Update(DateTime date, int temperature)
        {
            _weatherForecastModel.Update(date, temperature);
            return Ok();
        }

        [HttpDelete("delete")]
        public ActionResult<Boolean> Delete(DateTime date)
        {
            bool deleteResult = _weatherForecastModel.Delete(date);
            return Ok(deleteResult);
        }

        [HttpGet("getall")]
        public ActionResult<List<WeatherForecast>> GetAll(DateTime fromDate, DateTime toDate)
        {
            List<WeatherForecast> weatherForecasts = _weatherForecastModel.GetAll(fromDate, toDate);
            return Ok(weatherForecasts);
        }
    }
}
