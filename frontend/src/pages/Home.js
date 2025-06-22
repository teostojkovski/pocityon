import React, { useEffect, useState } from 'react';
import { Typography, Grid, Card, CardContent, CardActions, Button, CircularProgress, Avatar, TextField, Box } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

function Home() {
  const [cities, setCities] = useState([]);
  const [loading, setLoading] = useState(true);
  const [search, setSearch] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    axios.get('http://localhost:8080/api/cities')
      .then(res => {
        setCities(res.data);
        setLoading(false);
      })
      .catch(() => setLoading(false));
  }, []);

  const filteredCities = cities.filter(city =>
    city.name.toLowerCase().includes(search.toLowerCase())
  );

  if (loading) return <Box sx={{ display: 'flex', justifyContent: 'center', mt: 8 }}><CircularProgress /></Box>;

  return (
    <Box>
      <Typography variant="h4" gutterBottom>Explore Cities</Typography>
      <TextField
        label="Search city..."
        variant="outlined"
        value={search}
        onChange={e => setSearch(e.target.value)}
        sx={{ mb: 4, width: '100%', maxWidth: 400 }}
      />
      {filteredCities.length === 0 ? (
        <Typography variant="body1" color="text.secondary">No cities found.</Typography>
      ) : (
        <Grid container spacing={3}>
          {filteredCities.map(city => (
            <Grid item xs={12} sm={6} md={4} key={city.id}>
              <Card sx={{ cursor: 'pointer', transition: '0.2s', '&:hover': { boxShadow: 6 } }} onClick={() => navigate(`/city/${city.id}`)}>
                <Box sx={{ display: 'flex', alignItems: 'center', p: 2 }}>
                  <Avatar sx={{ width: 56, height: 56, mr: 2 }} src={city.coverImage || undefined}>
                    {city.name[0]}
                  </Avatar>
                  <Box>
                    <Typography variant="h6">{city.name}</Typography>
                    <Typography color="text.secondary" variant="body2">{city.description}</Typography>
                  </Box>
                </Box>
              </Card>
            </Grid>
          ))}
        </Grid>
      )}
    </Box>
  );
}

export default Home; 