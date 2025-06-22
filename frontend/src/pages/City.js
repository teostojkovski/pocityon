import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { Typography, Grid, Card, CardContent, CardMedia, CardActions, Button, CircularProgress, Chip, Tabs, Tab, Box, Fab, Avatar } from '@mui/material';
import AddIcon from '@mui/icons-material/Add';
import axios from 'axios';

function City() {
  const { cityId } = useParams();
  const [city, setCity] = useState(null);
  const [categories, setCategories] = useState([]);
  const [places, setPlaces] = useState([]);
  const [loading, setLoading] = useState(true);
  const [tab, setTab] = useState(0);
  const navigate = useNavigate();

  useEffect(() => {
    Promise.all([
      axios.get(`http://localhost:8080/api/cities/${cityId}`),
      axios.get('http://localhost:8080/api/categories'),
      axios.get(`http://localhost:8080/api/places/city/${cityId}`)
    ]).then(([cityRes, catRes, placesRes]) => {
      setCity(cityRes.data);
      setCategories(catRes.data);
      setPlaces(placesRes.data);
      setLoading(false);
    }).catch(() => setLoading(false));
  }, [cityId]);

  if (loading) return <Box sx={{ display: 'flex', justifyContent: 'center', mt: 8 }}><CircularProgress /></Box>;
  if (!city) return <Typography>City not found.</Typography>;

  // Filter places by selected category
  const filteredPlaces = tab === 0
    ? places
    : places.filter(place => place.category && place.category.id === categories[tab - 1].id);

  return (
    <Box>
      <Typography variant="h4" gutterBottom>{city.name}</Typography>
      <Typography variant="subtitle1" gutterBottom>{city.description}</Typography>
      <Tabs
        value={tab}
        onChange={(_, v) => setTab(v)}
        sx={{ mb: 3 }}
        variant="scrollable"
        scrollButtons="auto"
      >
        <Tab label="All" />
        {categories.map(cat => (
          <Tab key={cat.id} label={cat.name} />
        ))}
      </Tabs>
      {filteredPlaces.length === 0 ? (
        <Typography variant="body1" color="text.secondary">No places found in this category.</Typography>
      ) : (
        <Grid container spacing={3}>
          {filteredPlaces.map(place => (
            <Grid item xs={12} sm={6} md={4} key={place.id}>
              <Card sx={{ cursor: 'pointer', transition: '0.2s', '&:hover': { boxShadow: 6 } }} onClick={() => navigate(`/place/${place.id}`)}>
                {place.logo && (
                  <CardMedia component="img" height="140" image={place.logo} alt={place.name} />
                )}
                <CardContent>
                  <Box sx={{ display: 'flex', alignItems: 'center', mb: 1 }}>
                    <Avatar sx={{ mr: 2 }} src={place.logo || undefined}>{place.name[0]}</Avatar>
                    <Box>
                      <Typography variant="h6">{place.name}</Typography>
                      <Typography color="text.secondary" variant="body2">{place.description}</Typography>
                    </Box>
                  </Box>
                  <Typography variant="body2">Category: {place.category?.name}</Typography>
                </CardContent>
                <CardActions>
                  <Button size="small" onClick={e => { e.stopPropagation(); navigate(`/place/${place.id}`); }}>Details</Button>
                </CardActions>
              </Card>
            </Grid>
          ))}
        </Grid>
      )}
      <Fab color="primary" aria-label="add" sx={{ position: 'fixed', bottom: 32, right: 32 }} onClick={() => alert('Add place functionality coming soon!')}>
        <AddIcon />
      </Fab>
    </Box>
  );
}

export default City; 